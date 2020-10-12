package trung.com.dtos;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.sun.istack.NotNull;

public class ProujectDto implements Serializable {
	private Integer id;
	@NotNull
	private String name;
	@NotNull
	private MultipartFile image;
	@NotNull
	private String category;
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
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public ProujectDto(Integer id, String name, MultipartFile image, String category) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.category = category;
	}
	public ProujectDto() {
		super();
	}
	
}
