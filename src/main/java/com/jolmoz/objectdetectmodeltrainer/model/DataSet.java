package com.jolmoz.objectdetectmodeltrainer.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Transient;

@Entity
public class DataSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String dataSetName;

    @Column(nullable = true)
    private String dataSetDescription;

    @OneToMany(mappedBy = "dataSet", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Asset> assets;

    @OneToMany(mappedBy = "dataSet", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Tag> tags;

    private long userAccessCreatorId;

    private long userAccessLastEditorId;

    @CreationTimestamp
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime modifiedDate;

    private int version;

    @Transient
    private boolean unchangeVersion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDataSetName() {
        return dataSetName;
    }

    public void setDataSetName(String dataSetName) {
        this.dataSetName = dataSetName;
    }

    public String getDataSetDescription() {
        return dataSetDescription;
    }

    public void setDataSetDescription(String dataSetDescription) {
        this.dataSetDescription = dataSetDescription;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public boolean isUnchangeVersion() {
        return unchangeVersion;
    }

    public void setUnchangeVersion(boolean unchangeVersion) {
        this.unchangeVersion = unchangeVersion;
    }

    @PreUpdate
    public void changeVersion() {
        if (!this.isUnchangeVersion()) {
            this.setVersion(this.getVersion() + 1);
            this.setUnchangeVersion(true);
        }
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public long getUserAccessCreatorId() {
        return userAccessCreatorId;
    }

    public void setUserAccessCreatorId(long userAccessCreatorId) {
        this.userAccessCreatorId = userAccessCreatorId;
    }

    public long getUserAccessLastEditorId() {
        return userAccessLastEditorId;
    }

    public void setUserAccessLastEditorId(long userAccessLastEditorId) {
        this.userAccessLastEditorId = userAccessLastEditorId;
    }
    
}
