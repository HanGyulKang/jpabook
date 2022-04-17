package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.service.dto.UpdateItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, UpdateItemDto dto) {
        // 영속상태의 아이템을 찾아 옴
        Item findItem = itemRepository.findOne(itemId);
        findItem.change(dto);

//        findItem.setName(dto.getName());
//        findItem.setPrice(dto.getPrice());
//        findItem.setStockQuantity(dto.getStockQuantity());
        // Transactional을 걸어주면 commit이 되는 시점에 flush를 진행 함
        // flush가 진행되고 JPA가 영속성 컨텍스트 중 변경 된 데이터를 체크하게 됨(=dirty checking)
        // 변경 감지를 통해 데이터를 변경 함

        // findItem으로 찾아왔을 때는 영속상태이기 때문에 save를 따로 할 필요가 없음.
        // itemRepository.save(findItem);
    }

    public List<Item> fineItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
