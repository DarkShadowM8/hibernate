package com.example.mvc_task.enums;

public enum Gender {
	Male ("Male"),
	Female ("Female"),
	Other ("Other");
	
	 private String displayName;

	 Gender(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
