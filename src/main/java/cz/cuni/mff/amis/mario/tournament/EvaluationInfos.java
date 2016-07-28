package cz.cuni.mff.amis.mario.tournament;

import ch.idsia.tools.EvaluationInfo;

import java.util.ArrayList;
import java.util.List;

public class EvaluationInfos {

    public int totalVictories;
    public double avgVictories;
    public int totalDeaths;
    public double avgDeaths;
    public int totalTimedout;
    public double avgTimedout;
    public int totalTimeSpent;
    public double avgTimeSpent;
    private List<EvaluationInfo> results = new ArrayList<>();

    public List<EvaluationInfo> getResults() {
        return results;
    }

    public void addResult(EvaluationInfo result) {
        switch (result.getResult()) {
            case LEVEL_TIMEDOUT:
                ++totalTimedout;
                break;
            case MARIO_DIED:
                ++totalDeaths;
                break;
            case VICTORY:
                ++totalVictories;
                break;
            default:
                // IGNORING
                return;
        }

        results.add(result);

        totalTimeSpent += result.timeSpent;

        avgVictories = ((double) totalVictories) / ((double) results.size());
        avgDeaths = ((double) totalDeaths) / ((double) results.size());
        avgTimedout = ((double) totalTimedout) / ((double) results.size());

        avgTimeSpent = ((double) totalTimeSpent) / ((double) results.size());
    }

    public void addResults(EvaluationInfo... results) {
        for (EvaluationInfo info : results) {
            addResult(info);
        }
    }

    public void addResults(List<EvaluationInfo> results) {
        results.forEach(this::addResult);
    }

    public String getCSVHeader() {
        return "rounds;totalVictories;avgVictories;totalDeaths;avgDeaths;totalTimedout;avgTimedout;totalTimeSpent;avgTimeSpent";
    }

    public String getCSV() {
        return results.size()
                + ";" + totalVictories + ";" + avgVictories
                + ";" + totalDeaths + ";" + avgDeaths
                + ";" + totalTimedout + ";" + avgTimedout
                + ";" + totalTimeSpent + ";" + avgTimeSpent;
    }

    @Override
    public String toString() {
        return "EvaluationInfos[RUNS=" + results.size() + ", AVGS: WIN=" + avgVictories + ", DEATH=" + avgDeaths + ", TIMEOUT=" + avgTimedout + ", TIME=" + avgTimeSpent + "]";
    }

}
