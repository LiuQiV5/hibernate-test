package com.liuqi.entity.v8;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CATEGORY_ITEM")
@Immutable
public class CategorizedItem {

    @Embeddable
    public static class Id implements Serializable {

        @Column(name = "CATEGORY_ID")
        protected Long categoryId;

        @Column(name = "ITEM_ID")
        protected Long itemId;

        public Id(){

        }

        public Id(Long categoryId, Long itemId) {
            this.categoryId = categoryId;
            this.itemId = itemId;
        }

        @Override
        public boolean equals(Object obj) {

            if (obj != null && obj instanceof Id) {
                Id that = (Id) obj;
                return this.categoryId.equals(that.categoryId) && this.itemId.equals(that.itemId);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return categoryId.hashCode()+itemId.hashCode();
        }
    }

    @EmbeddedId
    protected Id id = new Id();

    @Column(updatable = false)
    @NotNull
    protected String addedBy;

    @NotNull
    @Column(updatable = false)
    protected Date addedOn = new Date();

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID",insertable = false,updatable = false)
    protected CategoryV2 categoryV2;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID",insertable = false,updatable = false)
    protected ItemV3 itemV3;

    public CategorizedItem() {
    }

    public CategorizedItem(String addedBy, CategoryV2 categoryV2, ItemV3 itemV3) {
        this.addedBy = addedBy;
        this.categoryV2 = categoryV2;
        this.itemV3 = itemV3;

        this.id.categoryId = categoryV2.getId();
        this.id.itemId = itemV3.getId();

        categoryV2.getCategorizedItems().add(this);
        itemV3.getCategorizedItems().add(this);
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    public CategoryV2 getCategoryV2() {
        return categoryV2;
    }

    public void setCategoryV2(CategoryV2 categoryV2) {
        this.categoryV2 = categoryV2;
    }

    public ItemV3 getItemV3() {
        return itemV3;
    }

    public void setItemV3(ItemV3 itemV3) {
        this.itemV3 = itemV3;
    }
}
