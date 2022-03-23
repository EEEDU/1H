package ExamenA;

public class ExamenA001 {

	public static void main(String[] args) {
		int[] recaudacionA = { 12, 43, 59, 23, 44, 23, 54, 64 };
		int[] recaudacionB = { 15, 23, 12, 74, 23, 65, 12, 12 };
		int[] recaudacionMedia = new int[recaudacionA.length];

		recaudacionMedia = hacerMedia(recaudacionA, recaudacionB);

		for (int i = 0; i < recaudacionMedia.length; i++) {
			System.out.println(recaudacionMedia[i]);
		}
	}

	public static int[] hacerMedia(int[] recA, int[] recB) {
		int media[] = new int[recA.length];
		for (int i = 0; i < media.length; i++) {
			media[i] = (recA[i] + recB[i]) / 2;
		}
		return media;
	}
}
