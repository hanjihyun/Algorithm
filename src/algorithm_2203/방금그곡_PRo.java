package algorithm_2203;

public class 방금그곡_PRo {
	public static void main(String[] args) {
		String m = "ABCDEFG";
		String[] musicinfos = { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" };
		int max = -1;
		String answer = "";

		m = changeMelody(m);

		for (String musicInfo : musicinfos) {
			String[] info = musicInfo.split(",");
			String title = info[2];
			String melodyInfo = changeMelody(info[3]);

			String[] timeInfo = info[0].split(":");
			int start = Integer.valueOf(timeInfo[0]) * 60 + Integer.valueOf(timeInfo[1]);
			int end = 0;

			timeInfo = info[1].split(":");
			end = Integer.valueOf(timeInfo[0]) * 60 + Integer.valueOf(timeInfo[1]);

			int play = end - start;

			if (play > melodyInfo.length()) {
				StringBuilder newMelody = new StringBuilder();

				for (int i = 0; i < play / melodyInfo.length(); i++)
					newMelody.append(melodyInfo);

				newMelody.append(melodyInfo.substring(0, play % melodyInfo.length()));
				melodyInfo = newMelody.toString();
			} else {
				melodyInfo = melodyInfo.substring(0, play);
			}

			if (melodyInfo.contains(m) && play > max) {
				answer = title;
				max = play;
			}

		}

		if (max == -1) {
			answer = "(None)";
		}
		System.out.println(answer);
	}

	private static String changeMelody(String old) {
		old = old.replaceAll("C#", "H");
		old = old.replaceAll("D#", "I");
		old = old.replaceAll("F#", "J");
		old = old.replaceAll("G#", "K");
		String newM = old.replaceAll("A#", "L");

		return newM;
	}
}
