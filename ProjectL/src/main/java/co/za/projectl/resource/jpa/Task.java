package co.za.projectl.resource.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

@Entity
@Table(name="Task")
public class Task {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Transient
	@Column(name = "id")
    private long id;
	
	@Column(nullable = false, name = "description")
    private String description;
	
	@Column(nullable = true, name = "comment")
    private String comment;
    
    @Column(nullable = false, name = "date_to_complete")
    private Date dateToComplete;
    
    @Column(nullable = false, name = "date_created")
    private Date dateCreated;

    @Column(nullable = false, name = "created_by")
    private Long createdBy;
    
    @Column(nullable = false, name = "created_for")
    private Long createdFor;
    
    protected Task() {}

	public Task(String description, String comment, Date dateToComplete, Date dateCreated, Long createdBy,
			Long createdFor) {
		super();
		this.description = description;
		this.comment = comment;
		this.dateToComplete = dateToComplete;
		this.dateCreated = dateCreated;
		this.createdBy = createdBy;
		this.createdFor = createdFor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDateToComplete() {
		return dateToComplete;
	}

	public void setDateToComplete(Date dateToComplete) {
		this.dateToComplete = dateToComplete;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getCreatedFor() {
		return createdFor;
	}

	public void setCreatedFor(Long createdFor) {
		this.createdFor = createdFor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((createdFor == null) ? 0 : createdFor.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((dateToComplete == null) ? 0 : dateToComplete.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdFor == null) {
			if (other.createdFor != null)
				return false;
		} else if (!createdFor.equals(other.createdFor))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (dateToComplete == null) {
			if (other.dateToComplete != null)
				return false;
		} else if (!dateToComplete.equals(other.dateToComplete))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", " + (description != null ? "description=" + description + ", " : "")
				+ (comment != null ? "comment=" + comment + ", " : "")
				+ (dateToComplete != null ? "dateToComplete=" + dateToComplete + ", " : "")
				+ (dateCreated != null ? "dateCreated=" + dateCreated + ", " : "")
				+ (createdBy != null ? "createdBy=" + createdBy + ", " : "")
				+ (createdFor != null ? "createdFor=" + createdFor : "") + "]";
	}

}
