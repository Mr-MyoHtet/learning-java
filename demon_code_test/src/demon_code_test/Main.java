package demon_code_test;

import java.math.BigDecimal;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Sample data – DB ကနေ select လိုက်သလို simulate
        List<CashManagementInfoServiceData> result = Arrays.asList(
            new CashManagementInfoServiceData("A", new BigDecimal("1000"), 2, "01"),
            new CashManagementInfoServiceData("B", new BigDecimal("500"), 1, "02"),
            new CashManagementInfoServiceData("A", new BigDecimal("300"), 1, "03"),
            new CashManagementInfoServiceData("A", new BigDecimal("200"), 2, "04"),
            new CashManagementInfoServiceData("A", new BigDecimal("200"), 2, "04"),
            new CashManagementInfoServiceData("C", new BigDecimal("150"), 1, "05"),
            new CashManagementInfoServiceData("A", new BigDecimal("400"), 2, "06"),
            new CashManagementInfoServiceData("D", new BigDecimal("50"), 1, null)
        );

        // Map<demonCode, Map<conditionKey, BigDecimal/Integer>>
        Map<String, Map<String, BigDecimal>> totalAmountMap = new HashMap<>();
        Map<String, Map<String, Integer>> totalQtyMap = new HashMap<>();

        for (CashManagementInfoServiceData data : result) {
            String demonCode = data.demonCode == null ? "null" : data.demonCode;
            BigDecimal amount = data.amount == null ? BigDecimal.ZERO : data.amount;
            int qty = data.qty == null ? 0 : data.qty;
            String packingCode = data.packingCode;

            // 4 conditions – null-safe, all if statements
            if (packingCode == null) {
                addAmountQty(totalAmountMap, totalQtyMap, demonCode, "COND_NULL", amount, qty);
            }
            if ("01".equals(packingCode) || "02".equals(packingCode)) {
                addAmountQty(totalAmountMap, totalQtyMap, demonCode, "COND_01_02", amount, qty);
            }

            if ("03".equals(packingCode) || "04".equals(packingCode)) {
                addAmountQty(totalAmountMap, totalQtyMap, demonCode, "COND_03_04", amount, qty);
            }

            if ("05".equals(packingCode) || "06".equals(packingCode)) {
                addAmountQty(totalAmountMap, totalQtyMap, demonCode, "COND_05_06", amount, qty);
            }
        }

        // Print results
        totalAmountMap.forEach((demonCode, amtMap) -> {
            Map<String, Integer> qtyMap = totalQtyMap.getOrDefault(demonCode, Collections.emptyMap());
            amtMap.forEach((cond, amt) -> {
                int groupQty = qtyMap.getOrDefault(cond, 0);
                System.out.println("DemonCode: " + demonCode +
                        " , Condition: " + cond +
                        " → Amount = " + amt + " , Qty = " + groupQty);
            });
        });
    }

    // Helper method to sum amount and qty
    private static void addAmountQty(Map<String, Map<String, BigDecimal>> totalAmountMap,
                                     Map<String, Map<String, Integer>> totalQtyMap,
                                     String demonCode,
                                     String conditionKey,
                                     BigDecimal amount,
                                     int qty) {
        // Sum amount
        totalAmountMap.putIfAbsent(demonCode, new HashMap<>());
        Map<String, BigDecimal> amtMap = totalAmountMap.get(demonCode);
        amtMap.put(conditionKey, amtMap.getOrDefault(conditionKey, BigDecimal.ZERO).add(amount));

        // Sum qty
        totalQtyMap.putIfAbsent(demonCode, new HashMap<>());
        Map<String, Integer> qtyMap = totalQtyMap.get(demonCode);
        qtyMap.put(conditionKey, qtyMap.getOrDefault(conditionKey, 0) + qty);
    }
}

// Entity class – public fields, no getters
class CashManagementInfoServiceData {
    public String demonCode;
    public BigDecimal amount;
    public Integer qty;
    public String packingCode;

    public CashManagementInfoServiceData(String demonCode, BigDecimal amount, Integer qty, String packingCode) {
        this.demonCode = demonCode;
        this.amount = amount;
        this.qty = qty;
        this.packingCode = packingCode;
    }
}
