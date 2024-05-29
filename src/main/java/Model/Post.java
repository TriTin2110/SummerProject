package Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Post {
	@ManyToOne
	@JoinColumn(name = "listPost")
	private User userIdPost;
	@Id
	private String postId;
	private String postImage; // Hình ảnh
	private String postContent;
	private Integer postInteract;
	private Integer postShare;
	@OneToMany(mappedBy = "post")
	private List<Comment> postCommentList;

	public Post() {
		super();
	}

	public Post(User user, String postId, String postImage, String postContent, Integer postInteract, Integer postShare,
			List<Comment> postCommentList) {
		super();
		this.userIdPost = user;
		this.postId = postId;
		this.postImage = postImage;
		this.postContent = postContent;
		this.postInteract = postInteract;
		this.postShare = postShare;
		this.postCommentList = postCommentList;
	}

	public User getUser() {
		return userIdPost;
	}

	public void setUser(User user) {
		this.userIdPost = user;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getPostImage() {
		return postImage;
	}

	public void setPostImage(String postImage) {
		this.postImage = postImage;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Integer getPostInteract() {
		return postInteract;
	}

	public void setPostInteract(Integer postInteract) {
		this.postInteract = postInteract;
	}

	public Integer getPostShare() {
		return postShare;
	}

	public void setPostShare(Integer postShare) {
		this.postShare = postShare;
	}

	public List<Comment> getPostCommentList() {
		return postCommentList;
	}

	public void setPostCommentList(List<Comment> postCommentList) {
		this.postCommentList = postCommentList;
	}

}
