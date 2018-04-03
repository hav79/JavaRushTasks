package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

    Stack<Tile[][]> previousStates = new Stack<>();
    Stack<Integer> previousScores = new Stack<>();
    boolean isSaveNeeded = true;

    int score;
    int maxTile;

    public Model() {
        resetGameTiles();
//        gameTiles = new Tile[][]{{new Tile(4), new Tile(2), new Tile(8), new Tile(4)},
//                {new Tile(4), new Tile(8), new Tile(2), new Tile(4)},
//                {new Tile(16), new Tile(16), new Tile(4), new Tile(2)},
//                {new Tile(2), new Tile(4), new Tile(8), new Tile(2)}};
    }

    public void resetGameTiles() {
        score = 0;
        maxTile = 2;
        for (int i = 0; i < FIELD_WIDTH; i++)
            for (int j = 0; j < FIELD_WIDTH; j++)
                gameTiles[i][j] = new Tile();
        addTile();
        addTile();
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (emptyTiles.size() > 0) {
            int randomNumber = (int) (Math.random() * emptyTiles.size());
            int randomValue = (Math.random() < 0.9 ? 2 : 4);
            emptyTiles.get(randomNumber).value = randomValue;
            if (randomValue == 4 && maxTile < 4) maxTile = 4;
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++)
            for (int j = 0; j < FIELD_WIDTH; j++)
                if (gameTiles[i][j].isEmpty())
                    emptyTiles.add(gameTiles[i][j]);
        return emptyTiles;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean changed = false;
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].isEmpty()) {
                int j = i;
                while (j < tiles.length - 1 && tiles[j].isEmpty()) j++;
                if (!tiles[j].isEmpty()) {
                    tiles[i].value = tiles[j].value;
                    tiles[j].value = 0;
                    changed = true;
                }
            }
        }
        return changed;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean changed = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == 0) continue;
            if (tiles[i].value == tiles[i + 1].value) {
                tiles[i].value += tiles[i].value;
                tiles[i + 1].value = 0;
                score += tiles[i].value;
                if (tiles[i].value > maxTile) maxTile = tiles[i].value;
                changed = true;
            }
        }
        compressTiles(tiles);
        return changed;
    }

    public void left() {
        if (isSaveNeeded)
            saveState(gameTiles);
        boolean changed = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            Tile[] line = gameTiles[i];
            if (compressTiles(line) | mergeTiles(line)) changed = true;
        }
        if (changed) addTile();
        isSaveNeeded = true;
    }

    public void right() {
        saveState(gameTiles);
        rotateRight();
        rotateRight();
        left();
        rotateLeft();
        rotateLeft();
    }

    public void up() {
        saveState(gameTiles);
        rotateLeft();
        left();
        rotateRight();
    }

    public void down() {
        saveState(gameTiles);
        rotateRight();
        left();
        rotateLeft();
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
        }
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Collections.reverseOrder());
        queue.add(getMoveEfficiency(this::left));
        queue.add(getMoveEfficiency(this::right));
        queue.add(getMoveEfficiency(this::up));
        queue.add(getMoveEfficiency(this::down));
        queue.poll().getMove().move();
    }


    private void rotateRight() {
        int[][] rotatedTiles = new int[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; ++i)
            for (int j = 0; j < FIELD_WIDTH; ++j)
                rotatedTiles[i][j] = gameTiles[FIELD_WIDTH - j - 1][i].value;
        for (int i = 0; i < FIELD_WIDTH; i++)
            for (int j = 0; j < FIELD_WIDTH; j++)
                gameTiles[i][j].value = rotatedTiles[i][j];
    }

    private void rotateLeft() {
        int[][] rotatedTiles = new int[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; ++i)
            for (int j = 0; j < FIELD_WIDTH; ++j)
                rotatedTiles[i][j] = gameTiles[j][FIELD_WIDTH - i - 1].value;
        for (int i = 0; i < FIELD_WIDTH; i++)
            for (int j = 0; j < FIELD_WIDTH; j++)
                gameTiles[i][j].value = rotatedTiles[i][j];
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public int getScore() {
        return score;
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) return true;

        for (int i = 0; i < FIELD_WIDTH; i++)
            for (int j = 1; j < FIELD_WIDTH; j++)
                if (gameTiles[i][j].value == gameTiles[i][j - 1].value)
                    return true;
        for (int i = 0; i < FIELD_WIDTH; i++)
            for (int j = 1; j < FIELD_WIDTH; j++)
                if (gameTiles[j][i].value == gameTiles[j - 1][i].value)
                    return true;
        return false;
    }

    public void saveState(Tile[][] tiles) {
        Tile[][] state = new Tile[tiles.length][tiles.length];
        for (int i = 0; i < tiles.length; i++)
            for (int j = 0; j < tiles.length; j++)
                state[i][j] = new Tile(tiles[i][j].value);
        previousStates.push(state);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.empty() && !previousScores.empty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public boolean hasBoardChanged() {
        return getTilesWeight(previousStates.peek()) != getTilesWeight(gameTiles);
    }

    private int getTilesWeight(Tile[][] tiles) {
        int weight = 0;
        for (int i = 0; i < tiles.length; i++)
            for (int j = 0; j < tiles.length; j++)
                weight += tiles[i][j].value;
        return weight;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        MoveEfficiency moveEfficiency;
        if (hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
            rollback();
        }
        else {
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        }
        return moveEfficiency;
    }
}
