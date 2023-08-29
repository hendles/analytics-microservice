package app.lunapos.models.bases;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@MappedSuperclass
public class BaseModel extends PanacheEntityBase {

    @Column(name = "created_by", nullable = true)
    public String createdBy;

    @Column(name = "created_datetime", nullable = true)
    public LocalDateTime createdDatetime = LocalDateTime.now(ZoneOffset.UTC);

    public String getCreatedBy() { return createdBy; }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(LocalDateTime createdDatetime) {
        this.createdDatetime = createdDatetime;
    }
}
