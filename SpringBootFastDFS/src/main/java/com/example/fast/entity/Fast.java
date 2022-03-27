package com.example.fast.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author shyheng
 * @since 2022-03-27
 */

public class Fast implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String groupName;

    private String remoteFile;

    private String oldFile;

    private Long fileSize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public String getRemoteFile() {
        return remoteFile;
    }

    public void setRemoteFile(String remoteFile) {
        this.remoteFile = remoteFile;
    }
    public String getOldFile() {
        return oldFile;
    }

    public void setOldFile(String oldFile) {
        this.oldFile = oldFile;
    }
    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "Fast{" +
            "id=" + id +
            ", name=" + name +
            ", groupName=" + groupName +
            ", remoteFile=" + remoteFile +
            ", oldFile=" + oldFile +
            ", fileSize=" + fileSize +
        "}";
    }

    public Fast() {
    }

    public Fast(Integer id, String groupName, String remoteFile, String oldFile, Long fileSize) {
        this.id = id;
        this.groupName = groupName;
        this.remoteFile = remoteFile;
        this.oldFile = oldFile;
        this.fileSize = fileSize;
    }
}
