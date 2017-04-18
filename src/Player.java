public class Player {

	// ////FIELDS/////////
	String name = new String();
	String character = new String();
	int score = 0;

	// ////CONSTRUCTOR//////////
	Player(String pName, String pChar) {
		name = pName;
		character = pChar;
	}

	public String getScore() {
		return Integer.toString(score);
	}

	public void incrementScore() {
		score++;
	}

	void resetScore() {
		score = 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((character == null) ? 0 : character.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Player other = (Player) obj;
		if (character == null) {
			if (other.character != null)
				return false;
		} else if (!character.equals(other.character))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
