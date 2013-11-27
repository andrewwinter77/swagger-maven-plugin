package com.github.kongchen.swagger.docgen.mustache;

import java.util.List;

public class MustacheDataType implements Comparable<MustacheDataType> {

    String name;

    List<MustacheItem> items;

    String description;
    
    public MustacheDataType(MustacheDocument mustacheDocument, String requestType, String description) {
        this.name = requestType;
        this.items = mustacheDocument.analyzeDataTypes(requestType);
        this.description = description;
    }

    public MustacheDataType(MustacheDocument mustacheDocument, String requestType) {
        this(mustacheDocument, requestType, "")
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MustacheDataType that = (MustacheDataType) o;

        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    public List<MustacheItem> getItems() {
        return items;
    }

    public void setItems(List<MustacheItem> items) {
        this.items = items;
    }

    @Override
    public int compareTo(MustacheDataType o) {
        if (o == null) {
            return 1;
        }
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "MustacheDataType{" +
                "name='" + name + '\'' +
                "description='" + description + '\'' +
                ", items=" + items +
                '}';
    }
}
