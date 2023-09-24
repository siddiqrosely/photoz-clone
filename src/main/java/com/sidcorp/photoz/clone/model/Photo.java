package com.sidcorp.photoz.clone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

    @Table("PHOTOZ")
    public class Photo {
        @Id
        private Integer id;
        @NotEmpty
        private String file_name;

        @JsonIgnore
        private byte[] data;

        private String contentType;

        public Photo() {

        }
        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public byte[] getData() {
            return data;
        }

        public void setData(byte[] data) {
            this.data = data;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getFilename() {
            return file_name;
        }

        public void setFilename(String filename) {
            this.file_name = filename;
        }
    }
