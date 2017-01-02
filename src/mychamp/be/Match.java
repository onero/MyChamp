/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.be;

import java.util.ArrayList;

public class Match {

    private final int ID;

    private final String LOCATION;

    private final ArrayList<Team> TEAMS;

    private final int FINAL_SCORE;

    private final String WINNER_TEAM;

    public Match(int ID, String LOCATION, ArrayList<Team> teams, int FINAL_SCORE, String WINNER_TEAM) {
        this.ID = ID;
        this.LOCATION = LOCATION;
        this.TEAMS = teams;
        this.FINAL_SCORE = FINAL_SCORE;
        this.WINNER_TEAM = WINNER_TEAM;
    }

    /**
     *
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     *
     * @return location of the match
     */
    public String getLOCATION() {
        return LOCATION;
    }

    /**
     *
     * @return TEAMS playing
     */
    public ArrayList<Team> getTeams() {
        return TEAMS;
    }

    /**
     *
     * @return final score of the match
     */
    public int getFINAL_SCORE() {
        return FINAL_SCORE;
    }

    /**
     *
     * @return the winner team
     */
    public String getWINNER_TEAM() {
        return WINNER_TEAM;
    }

}
