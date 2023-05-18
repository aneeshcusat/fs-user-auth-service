package com.fs.service.auth.repository.models;

import com.fs.service.auth.mapping.table.TableNameMapping;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Transient;
import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
@SuperBuilder(toBuilder=true)
public class BaseRepositoryModel implements Serializable {

    private static final long serialVersionUID = 2678875753774597201L;

    @Column(name = TableNameMapping.TableBaseModel.createdBy)
    private Long createdBy;

    @Column(name = TableNameMapping.TableBaseModel.createdDate)
    private Timestamp createdDate;

    @Column(name = TableNameMapping.TableBaseModel.lastModifiedDate)
    private Timestamp lastModifiedDate;

    @Column(name = TableNameMapping.TableBaseModel.modifiedBy)
    private Long modifiedBy;

    @Column(name = TableNameMapping.TableBaseModel.deleted)
    @Builder.Default
    private Boolean deleted = false;

    @Transient
    private transient  boolean modified;

    @Getter
    @Setter
    @SuperBuilder(toBuilder=true)
    @NoArgsConstructor
    public static class ItemInfo implements Serializable {
        private static final long serialVersionUID = 3061038159171584662L;
        private Long id;
        private Long createdBy;
        private LocalDateTime createdDate;
        private LocalDateTime lastModifiedDate;
        private Long modifiedBy;
        private Boolean deleted;
    }
}
