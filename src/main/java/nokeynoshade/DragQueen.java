package nokeynoshade;

import java.util.List;

public class DragQueen{
	private List<SeasonsItem> seasons;
	private boolean winner;
	private String quote;
	private boolean missCongeniality;
	private List<ChallengesItem> challenges;
	private String imageUrl;
	private String name;
	private int id;
	private List<LipsyncsItem> lipsyncs;
	private List<EpisodesItem> episodes;

	public List<SeasonsItem> getSeasons(){
		return seasons;
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

	public List<ChallengesItem> getChallenges(){
		return challenges;
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

	public List<LipsyncsItem> getLipsyncs(){
		return lipsyncs;
	}

	public List<EpisodesItem> getEpisodes(){
		return episodes;
	}
}