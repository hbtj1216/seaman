package com.tao.seaman.upm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class System implements Serializable {
    /**
     * 系统编号
     */
    private String systemId;

    /**
     * 图标
     */
    private String icon;

    /**
     * 背景
     */
    private String banner;

    /**
     * 主题
     */
    private String theme;

    /**
     * 根目录
     */
    private String basePath;

    /**
     * 状态(-1:黑名单,1:正常)
     */
    private Short status;

    /**
     * 系统名称
     */
    private String name;

    /**
     * 系统标题
     */
    private String title;

    /**
     * 系统描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 排序
     */
    private Integer order;

    private static final long serialVersionUID = 1L;

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        System other = (System) that;
        return (this.getSystemId() == null ? other.getSystemId() == null : this.getSystemId().equals(other.getSystemId()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getBanner() == null ? other.getBanner() == null : this.getBanner().equals(other.getBanner()))
            && (this.getTheme() == null ? other.getTheme() == null : this.getTheme().equals(other.getTheme()))
            && (this.getBasePath() == null ? other.getBasePath() == null : this.getBasePath().equals(other.getBasePath()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getOrder() == null ? other.getOrder() == null : this.getOrder().equals(other.getOrder()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSystemId() == null) ? 0 : getSystemId().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getBanner() == null) ? 0 : getBanner().hashCode());
        result = prime * result + ((getTheme() == null) ? 0 : getTheme().hashCode());
        result = prime * result + ((getBasePath() == null) ? 0 : getBasePath().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getOrder() == null) ? 0 : getOrder().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", systemId=").append(systemId);
        sb.append(", icon=").append(icon);
        sb.append(", banner=").append(banner);
        sb.append(", theme=").append(theme);
        sb.append(", basePath=").append(basePath);
        sb.append(", status=").append(status);
        sb.append(", name=").append(name);
        sb.append(", title=").append(title);
        sb.append(", description=").append(description);
        sb.append(", createTime=").append(createTime);
        sb.append(", order=").append(order);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}