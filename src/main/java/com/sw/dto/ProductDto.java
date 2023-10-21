package com.sw.dto;



public class ProductDto {
   public ProductDto() {}
   public ProductDto(int pId, String pName, int Price, int Count, String Kind, String Size, String Img, int Views) {
	   this.pid = pId;
	   this.pname = pName;
	   this.count = Count;
	   this.price = Price;
	   this.kind = Kind;
	   this.size = Size;
	   this.img = Img;
	   this.views = Views;
   }
   public int getPid() {
      return pid;
   }
   public void setPid(int pid) {
      pid = pid;
   }
   public String getPname() {
      return pname;
   }
   public void setPname(String pname) {
      this.pname = pname;
   }
   public int getPrice() {
      return price;
   }
   public void setPrice(int price) {
      this.price = price;
   }
   public int getCount() {
      return count;
   }
   public void setCount(int count) {
      this.count = count;
   }
   public String getKind() {
      return kind;
   }
   public void setKind(String kind) {
      this.kind = kind;
   }
   public String getSize() {
      return size;
   }
   public void setSize(String size) {
      this.size = size;
   }
   public String getImg() {
      return img;
   }
   public void setImg(String img) {
      this.img = img;
   }
   public int getViews() {
      return views;
   }
   public void setViews(int views) {
      this.views = views;
   }
   public int pid;
   public String pname;
   public int price;
   public int count;
   public String kind;
   public String size;
   public String img;
   public int views;   
   
   
   public int getPid2() {
      return Pid2;
   }
   public void setPid2(int pid2) {
      Pid2 = pid2;
   }
   public String getPname2() {
      return pname2;
   }
   public void setPname2(String pname2) {
      this.pname2 = pname2;
   }
   public int getPrice2() {
      return price2;
   }
   public void setPrice2(int price2) {
      this.price2 = price2;
   }
   public int getCount2() {
      return count2;
   }
   public void setCount2(int count2) {
      this.count2 = count2;
   }
   public String getKind2() {
      return kind2;
   }
   public void setKind2(String kind2) {
      this.kind2 = kind2;
   }
   public String getSize2() {
      return size2;
   }
   public void setSize2(String size2) {
      this.size2 = size2;
   }
   public String getImg2() {
      return img2;
   }
   public void setImg2(String img2) {
      this.img2 = img2;
   }
   public int getViews2() {
      return views2;
   }
   public void setViews2(int views2) {
      this.views2 = views2;
   }
   public int Pid2;
   public String pname2;
   public int price2;
   public int count2;
   public String kind2;
   public String size2;
   public String img2;
   public int views2;
}