package menu.domain;

public enum Category {
    KOREAN("한식"),
    JAPAN("일식"),
    CHINA("중식"),
    ASIAN("아시안"),
    WESTERN("양식");
    String name;
    private Category(String name){
        this.name = name;
    }

}
