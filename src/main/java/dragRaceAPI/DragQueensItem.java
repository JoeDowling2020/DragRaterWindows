package dragRaceAPI;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DragQueensItem{

	@JsonProperty("winner")
	private boolean winner;

	@JsonProperty("quote")
	private String quote;

	@JsonProperty("missCongeniality")
	private boolean missCongeniality;

	@JsonProperty("image_url")
	private String imageUrl;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("DragQueens")
	private List<DragQueensItem> dragQueens;

	public List<DragQueensItem> getDragQueens(){
		return dragQueens;
	}

	public boolean isWinner(){
		return winner;
	}

	public String getQuote(){
		return quote;
	}

	public boolean isMissCongeniality(){
		return missCongeniality;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	@Override
	public String toString() {
		return "DragQueensItem{" +
				"winner=" + winner +
				", quote='" + quote + '\'' +
				", missCongeniality=" + missCongeniality +
				", imageUrl='" + imageUrl + '\'' +
				", name='" + name + '\'' +
				", id=" + id +
				'}';
	}
}