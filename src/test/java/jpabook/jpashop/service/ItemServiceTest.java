package jpabook.jpashop.service;

import jpabook.jpashop.domain.Category;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.Assert.*;

public class ItemServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void saveItem() {
        Item item = new Item() {
            @Override
            public Long getId() {
                return super.getId();
            }

            @Override
            public String getName() {
                return super.getName();
            }

            @Override
            public int getPrice() {
                return super.getPrice();
            }

            @Override
            public int getStockQuantity() {
                return super.getStockQuantity();
            }

            @Override
            public List<Category> getCategories() {
                return super.getCategories();
            }

            @Override
            public void setId(Long id) {
                super.setId(id);
            }

            @Override
            public void setName(String name) {
                super.setName(name);
            }

            @Override
            public void setPrice(int price) {
                super.setPrice(price);
            }

            @Override
            public void setStockQuantity(int stockQuantity) {
                super.setStockQuantity(stockQuantity);
            }

            @Override
            public void setCategories(List<Category> categories) {
                super.setCategories(categories);
            }

            @Override
            public void addStock(int quantity) {
                super.addStock(quantity);
            }

            @Override
            public void removeStock(int quantity) {
                super.removeStock(quantity);
            }
        };

        item.setId(1L);

        itemService.saveItem(item);

        Assert.assertEquals(item, itemRepository.findOne(item.getId()));

    }

    @Test
    public void fineItems() {
    }

    @Test
    public void findOne() {
    }
}