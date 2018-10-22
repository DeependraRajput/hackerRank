package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElectionWinner {

	static String electionWinner(String[] votes) {

		Map<String, Integer> map = new HashMap<>();

		for (String name : votes) {
			Integer voteCount = map.get(name);
			if (voteCount == null)
				voteCount = Integer.valueOf(0);
			voteCount = voteCount + 1;
			map.put(name, voteCount);
		}

		List<Candidate> candidates = new ArrayList<Candidate>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			candidates.add(new Candidate(entry.getKey(), entry.getValue().intValue()));
		}

		Collections.sort(candidates);
		return candidates.get(0).getName();

	}

	public static void main(String[] args) {

		String a[] = new String[] { "Alex",
				"Michael",
				"Harry",
				"Dave",
				"Michael",
				"Victor",
				"Harry",
				"Alex",
				"Mary",
				"Mary"
		};

		ElectionWinner.electionWinner(a);

	}

	static class Candidate implements Comparable<Candidate> {

		public Candidate(String name, int votes) {
			this.name = name;
			this.votes = votes;
		}

		private String name;
		private int votes;

		public String getName() {
			return name;
		}

		public int getVotes() {
			return votes;
		}

		public void setVotes(int votes) {
			this.votes = votes;
		}

		@Override
		public int compareTo(Candidate o) {
			int result = o.votes - this.votes;
			if (result == 0) {
				result = o.name.compareTo(this.name);
			}
			return result;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
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
			Candidate other = (Candidate) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
	}

}
