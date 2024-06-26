package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StorageSteps {
    private final WarehouseSystem system = new WarehouseSystem();
    private int totalQuantity = 0;

    @Given("I have access to the warehouse management system")
    public void i_have_access_to_warehouse_management_system() {
        system.login("admin", "adminpassword");
    }

    @When("I add the following goods")
    public void i_add_the_following_goods(List<Map<String, String>> goods) {
        for (Map<String, String> good : goods) {
            String name = good.get("name");
            int quantity = Integer.parseInt(good.get("quantity"));
            double price = Double.parseDouble(good.get("price"));
            system.addGood(new Good(name, quantity, price));
            totalQuantity += quantity;
        }
    }

    @Then("the system should contain all these goods")
    public void system_should_contain_all_these_goods() {
        assertTrue(system.hasAllGoods());
    }

    @Then("the total number of goods in storage should be {int}")
    public void the_total_number_of_goods_in_storage_should_be(Integer expectedTotalQuantity) {
        assertEquals(expectedTotalQuantity.intValue(), totalQuantity);
    }
}
