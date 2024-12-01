package in1007.w9.coursework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static String[] allNames = {
            "James",
            "Louis",
            "Komal",
            "Herman",
            "Jennifer",
            "Haris",
            "Ruben"
    };

    public static long[] allStudentIds = {
            240010001,
            240010002,
            240010003,
            240010004,
            240010005,
            240010006,
            240010007
    };

    public static ArrayList<ExpeditionMember> members = new ArrayList<ExpeditionMember>();

    public static void main(String[] args) {
        // get random number between 4 and 6 (4 inclusive to 7 exclusive)
        Random rand = new Random();
        int numberOfMembers = rand.nextInt(4, 7);

        // Get unique value for name/studentId numberOfMembers times.
        IntStream randomIndexStream = new Random().ints(0, allNames.length).distinct().limit(numberOfMembers);
        randomIndexStream.forEach(index -> {
            ExpeditionMember member = new ExpeditionMember(allNames[index], allStudentIds[index]);
            members.add(member);
        });

        // members array populated with between 4 to 6 (inclusive) entries

        ResearchExpedition pyramidExpedition = new ResearchExpedition(
                members.get(0), // expedition leader
                members.get(1), // archivist
                members.get(2) // field researcher
        );

        // get last three members
        List<ExpeditionMember> lastThreeMembers = members.subList(members.size() - 3, members.size());

        ResearchExpedition nileExpedition = new ResearchExpedition(
                lastThreeMembers.get(0), // expedition leader
                lastThreeMembers.get(1), // archivist
                lastThreeMembers.get(2) // field researcher
        );

        // Print names of each expedition
        ResearchExpedition[] expeditions = { pyramidExpedition, nileExpedition };
        for (ResearchExpedition expedition : expeditions) {
            System.out.printf("\r\nExpedition Leader: %s\r\n", expedition.getExpeditionLeaderName());
            System.out.printf("Archivist: %s\r\n", expedition.getArchivistName());
            System.out.printf("Field Researcher: %s\r\n", expedition.getFieldResearcherName());
        }

        if (ExpeditionMember.member_counter == members.size()) {
            System.out.println("\r\nSUCCESS");
        }
    }
}
