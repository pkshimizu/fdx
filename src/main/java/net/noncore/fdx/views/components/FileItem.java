package net.noncore.fdx.views.components;

import javafx.beans.property.SimpleStringProperty;

public class FileItem {
    private final SimpleStringProperty name;
    private final SimpleStringProperty size;
    private final SimpleStringProperty date;

    public FileItem(String name, String size, String date) {
        this.name = new SimpleStringProperty(name);
        this.size = new SimpleStringProperty(size);
        this.date = new SimpleStringProperty(date);
    }

    public String getName() {
        return this.name.get();
    }

    public String getSize() {
        return this.size.get();
    }

    public String getDate() {
        return this.date.get();
    }
}
