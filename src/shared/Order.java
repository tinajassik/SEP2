package shared;

import java.io.Serializable;

public class Order implements Serializable
{
  private Buyer buyer;
  private Seller seller;
  private BookForSale soldBook;

  private String buyerId;
  private String sellerId;
  private int soldBookId;

  public Order(Buyer buyer, Seller seller, BookForSale soldBook)
  {
    this.buyer = buyer;
    this.seller = seller;
    this.soldBook = soldBook;
  }

  public Order(String buyerId, String sellerId, int soldBookId) {
    this.buyerId = buyerId;
    this.sellerId = sellerId;
    this.soldBookId = soldBookId;
  }

  public Buyer getBuyer()
  {
    return buyer;
  }

  public void setBuyer(Buyer buyer)
  {
    this.buyer = buyer;
  }

  public Seller getSeller()
  {
    return seller;
  }

  public void setSeller(Seller seller)
  {
    this.seller = seller;
  }

  public BookForSale getSoldBook()
  {
    return soldBook;
  }

  public void setSoldBook(BookForSale soldBook)
  {
    this.soldBook = soldBook;
  }

  public String getBuyerUsername()
  {
    return buyer.getUsername();
  }

  public String getSellerUsername()
  {
    return seller.getUsername();
  }

  public int getSoldBookId()
  {
    return soldBook.getId();
  }
}
