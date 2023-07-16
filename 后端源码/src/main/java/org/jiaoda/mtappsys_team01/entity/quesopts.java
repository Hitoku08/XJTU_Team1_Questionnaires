package org.jiaoda.mtappsys_team01.entity;

import java.util.List;

public class quesopts {
    int questionnaire_id;
    List<quesopt> quesoptns;

    public int getQuestionnaire_id() {
        return questionnaire_id;
    }

    public void setQuestionnaire_id(int questionnaire_id) {
        this.questionnaire_id = questionnaire_id;
    }

    public List<quesopt> getQuesoptns() {
        return quesoptns;
    }

    public void setQuesoptns(List<quesopt> quesoptns) {
        this.quesoptns = quesoptns;
    }

    public quesopts(int questionnaire_id, List<quesopt> quesoptns) {
        this.questionnaire_id = questionnaire_id;
        this.quesoptns = quesoptns;
    }
    public quesopts(){}
}
