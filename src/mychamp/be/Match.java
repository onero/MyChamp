/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.be;

import java.io.Serializable;
import mychamp.bll.IDCreator;

public class Match implements Serializable {

    private final int ID;

    private final String LOCATION;

    private Team homeTeam;

    private Team awayTeam;

    private int homeTeamScore;

    private int awayTeamScore;

    private Team winnerTeam;

    private boolean isPlayed;

    private final IDCreator getNewID = IDCreator.getInstance();

    public Match(String LOCATION, Team home, Team away) {
        this.ID = getNewID.getMatchID();
        this.LOCATION = LOCATION;
        homeTeam = home;
        awayTeam = away;
        isPlayed = false;
        winnerTeam = null;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public Team getWinnerTeam() {
        return winnerTeam;
    }

    public void setWinnerTeam(Team winnerTeam) {
        this.winnerTeam = winnerTeam;
    }

    public void setIsPlayed() {
        this.isPlayed = true;
    }

    public boolean isPlayed() {
        return isPlayed;
    }

    /**
     * Return the losing team. Returns null if no winning team is set.
     *
     * @return
     */
    public Team getLoserTeam() {
        if (winnerTeam != null) {
            if (winnerTeam == homeTeam) {
                return awayTeam;
            } else {
                return homeTeam;
            }
        } else {
            return null;
        }
    }

    /**
     * Mark the match as benched if there is no opponent
     */
    public void benchMatch() {
        isPlayed = true;
    }
}
