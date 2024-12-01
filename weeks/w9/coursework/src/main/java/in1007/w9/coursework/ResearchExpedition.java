package in1007.w9.coursework;

public class ResearchExpedition {
    private ExpeditionMember expeditionLeader;
    private ExpeditionMember archivist;
    private ExpeditionMember fieldResearcher;

    public ResearchExpedition(ExpeditionMember expeditionLeader, ExpeditionMember archivist,
            ExpeditionMember fieldResearcher) {
        this.expeditionLeader = expeditionLeader;
        this.archivist = archivist;
        this.fieldResearcher = fieldResearcher;
    }

    public String getExpeditionLeaderName() {
        return expeditionLeader.getName();
    }

    public String getArchivistName() {
        return archivist.getName();
    }

    public String getFieldResearcherName() {
        return fieldResearcher.getName();
    }
}