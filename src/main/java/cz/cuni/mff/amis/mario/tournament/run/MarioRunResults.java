package cz.cuni.mff.amis.mario.tournament.run;

import cz.cuni.mff.amis.mario.tournament.EvaluationInfos;
import cz.cuni.mff.amis.mario.tournament.MarioConfig;

import java.util.ArrayList;
import java.util.List;

public class MarioRunResults extends EvaluationInfos {

    private List<MarioConfig> configs = new ArrayList<>();
    private List<MarioRunResult> runResults = new ArrayList<>();

    public void addRunResults(MarioRunResult... results) {
        for (MarioRunResult result : results) {
            runResults.add(result);
            configs.add(result.getConfig());
            addResults(result.getResults());
        }
    }

    public void addRunResults(List<MarioRunResult> results) {
        for (MarioRunResult result : results) {
            runResults.add(result);
            configs.add(result.getConfig());
            addResults(result.getResults());
        }
    }

    public List<MarioRunResult> getRunResults() {
        return runResults;
    }

    public List<MarioConfig> getConfigs() {
        return configs;
    }

}
