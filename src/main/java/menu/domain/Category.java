package menu.domain;

public enum Category {
    JAPAN("일식", 1),
    KOREAN("한식", 2),

    CHINA("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);
    String name;
    Integer index;

    public String getName() {
        return name;
    }

    private Category(String name, Integer index) {
        this.name = name;
        this.index = index;
    }

    public static Category getCategoryFromIndex(Integer index) {
        for (Category category : Category.values()) {
            if (category.index.equals(index)) {
                return category;
            }
        }
        // 나올 경우가 없으 므로 , null 처리
        return null;
    }

}
