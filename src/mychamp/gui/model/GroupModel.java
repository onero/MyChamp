/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.gui.model;

import java.util.ArrayList;
import mychamp.be.Group;
import mychamp.be.Match;
import mychamp.be.Team;
import mychamp.bll.GroupManager;
import mychamp.bll.RankingManager;

public class GroupModel {

    private ArrayList<Group> randomGroups;

    private ArrayList<Match> quarterMatches;

    private ArrayList<Group> finalGroups;

    private static GroupModel instance;

    private GroupManager groupManager = GroupManager.getInstance();

    private final TeamModel teamModel = TeamModel.getInstance();

    private final RankingManager rankingManager = RankingManager.getInstance();

    private boolean groupPlayOver;

    public static GroupModel getInstance() {
        if (instance == null) {
            instance = new GroupModel();
        }
        return instance;
    }

    private GroupModel() {
        randomGroups = new ArrayList<>();
        quarterMatches = new ArrayList<>();
        finalGroups = new ArrayList<>();
        finalGroups.add(new Group("Quarter Finals", teamModel.getQuarterFinalTeams()));
        finalGroups.add(new Group("Semi finals", teamModel.getSemiFinalTeams()));
        finalGroups.add(new Group("Finale", teamModel.getFinalTeams()));
        groupPlayOver = false;
    }

    /**
     *
     * @return the random groups
     */
    public ArrayList<Group> getGroups() {
        return randomGroups;
    }

    /**
     * Sends a request to the GroupManager for new random teams
     */
    public void createRandomGroups() {
        groupManager.setTeamIDS(teamModel.getTeamsAsArrayList());
        randomGroups = groupManager.getNewRandomGroups();
    }

    /**
     *
     * @return state of group plays
     */
    public boolean isGroupPlayOver() {
        groupPlayOver = groupManager.checkIfGroupPlayIsOver(randomGroups);
        if (groupPlayOver) {
            quarterMatches = groupManager.getQuarterFinalMatches();
        }
        return groupPlayOver;
    }

    /**
     *
     * @param group
     * @return group rankings
     */
    public ArrayList<Team> getRankings(int group) {
        return rankingManager.sortTeamRankingOrder(group);
    }

    /**
     *
     * @return Matches for the quarter final
     */
    public ArrayList<Match> getQuarterMatches() {
        return quarterMatches;
    }

    /**
     *
     * @return the final groups
     */
    public ArrayList<Group> getFinalGroups() {
        return finalGroups;
    }

}
