package cn.dzy.manage.boss.manage.controller;

import cn.dzy.manage.boss.manage.bean.BizResponse;
import cn.dzy.manage.boss.manage.bean.cart.Cart;
import cn.dzy.manage.boss.manage.dao.CartMapper;
import cn.dzy.manage.boss.manage.utils.DiscountUtil;
import cn.dzy.manage.boss.manage.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/dzy/cart")
public class CartController {

    @Autowired
    private CartMapper mapper;

    @GetMapping("/selling")
    public BizResponse queryCartBooksAndSellingByUserId(@RequestHeader("token") String token) {
        String userId = TokenUtil.getUserId(token).toString();
        System.out.println("userId = " + userId);
        List<Cart> carts = mapper.queryCartBooksAndSellingByUserId(userId);
        if (carts.size() == 0) {
            return BizResponse.of(301, null);
        }
        carts = DiscountUtil.getDiscountByCart(carts);
        return BizResponse.of(0, carts);
    }

    @GetMapping("/shortage")
    public BizResponse queryCartBooksAndShortageByUserId(@RequestHeader("token") String token) {
        String userId = TokenUtil.getUserId(token).toString();
        List<Cart> carts = mapper.queryCartBooksAndShortageByUserId(userId);
        if (carts.size() == 0) {
            return BizResponse.of(301, null);
        }
        carts = DiscountUtil.getDiscountByCart(carts);
        return BizResponse.of(0, carts);
    }

    @GetMapping("/{bookId}")
    public BizResponse queryBookExistedByBookId(@RequestHeader("token") String token, @PathVariable String bookId) {
        String userId = TokenUtil.getUserId(token).toString();
        String cartId = mapper.queryCartIdByUserId(userId);
        Cart cart = mapper.queryBookByCartIdAndBookId(cartId, bookId);
        System.out.println("cart = " + cart);
        return BizResponse.of(0, cart);
    }

    @GetMapping("/appearance")
    public BizResponse queryBookExistedByBookId(@RequestHeader("token") String token) {
        String userId = TokenUtil.getUserId(token).toString();
        String cartId = mapper.queryCartIdByUserId(userId);
        List<Cart> carts = mapper.queryBookAppearanceByCartIdAndBookId(cartId);
        carts.stream().forEach(temp -> System.out.println("temp = " + temp));
        carts = DiscountUtil.getDiscountByCart(carts);
        return BizResponse.of(0, carts);
    }

    @DeleteMapping("/{bookId}")
    public BizResponse queryCartBooksByUserId(@RequestHeader("token") String token, @PathVariable String bookId) {
        String userId = TokenUtil.getUserId(token).toString();
        mapper.delCartBookByUserIdAndBookId(userId, bookId);
        return BizResponse.of(0, "删除成功");
    }

    @PostMapping
    public BizResponse insertCartDetailedByCartIdAndBookId(@RequestHeader("token") String token, @RequestParam String bookId, @RequestParam String appearance) {
        String userId = TokenUtil.getUserId(token).toString();
        String cartId = mapper.queryCartIdByUserId(userId);
        mapper.insertCartDetailedByCartIdAndBookId(cartId, bookId, appearance);
        return BizResponse.of(0, "添加成功");
    }

    @PatchMapping
    public BizResponse patcCartDetailedByCartIdAndBookId(@RequestHeader("token") String token, @RequestParam String bookId, @RequestParam String appearance, @RequestParam String selection) {
        String userId = TokenUtil.getUserId(token).toString();
        String cartId = mapper.queryCartIdByUserId(userId);
        if (selection.equals("2")) {
            mapper.patchCartDetailedByCartIdAndBookId(appearance, cartId, bookId);
            Cart book = mapper.queryBookByCartIdAndBookId(cartId, bookId);
            System.out.println("book = " + book);
            mapper.patchCartDetailedSelectionByCartIdAndBookId(String.valueOf(book.getSelection()), cartId, bookId);
        } else {
            mapper.patchCartDetailedSelectionByCartIdAndBookId(selection, cartId, bookId);
        }
        return BizResponse.of(0, "修改成功");
    }

    @PatchMapping("/selectAll")
    public BizResponse patcCartDetailedAllSelectionByCartIdAndBookId(@RequestHeader("token") String token) {
        String userId = TokenUtil.getUserId(token).toString();
        String cartId = mapper.queryCartIdByUserId(userId);
        List<Cart> carts = mapper.queryCartBooksAndSellingByUserId(userId);
        if (carts.stream().filter(cart -> cart.getSelection() == 1).count() == carts.size()) {
            mapper.patcCartDetailedAllSelectionByCartIdAndBookId("0", cartId);
        } else {
            mapper.patcCartDetailedAllSelectionByCartIdAndBookId("1", cartId);
        }
        return BizResponse.of(0, "修改成功");
    }

}
