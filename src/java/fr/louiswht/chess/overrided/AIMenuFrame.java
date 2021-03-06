package fr.louiswht.chess.overrided;

import chess.gui.GamePanel;
import chess.gui.MenuFrame;
import fr.louiswht.chess.ChessAI;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class AIMenuFrame extends JFrame {
    private static final long serialVersionUID = 93543371734115264L;

    private AIGamePanel gamePanel;
    private MenuBar mb;
    private CheckboxMenuItem promoteQueen, promoteRook, promoteKnight, promoteBishop;

    public AIMenuFrame(@NotNull final ChessAI chessAI) {
        super("Chess");
        mb = new MenuBar();
        gamePanel = new AIGamePanel(chessAI);
        initPromote();
        this.setMenuBar(mb);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(gamePanel);
        setSize(800, 600);
        setVisible(true);
        gamePanel.start();
    }

    private void initPromote() {
        Menu m = new Menu("Promote Piece");
        promoteQueen = new CheckboxMenuItem("Promote to queen");
        promoteQueen.setState(true);
        m.add(promoteQueen);
        promoteRook = new CheckboxMenuItem("Promote to rook");
        m.add(promoteRook);
        promoteKnight = new CheckboxMenuItem("Promote to knight");
        m.add(promoteKnight);
        promoteBishop = new CheckboxMenuItem("Promote to bishop");
        m.add(promoteBishop);
        mb.add(m);
    }

    public boolean action(Event evt, Object arg) {

        // check promotion menu
        if (evt.target == promoteQueen) {
            gamePanel.setPromote('q');
            promoteQueen.setState(true);
            promoteRook.setState(false);
            promoteBishop.setState(false);
            promoteKnight.setState(false);
        } else if (evt.target == promoteRook) {
            gamePanel.setPromote('r');
            promoteQueen.setState(false);
            promoteRook.setState(true);
            promoteBishop.setState(false);
            promoteKnight.setState(false);
        } else if (evt.target == promoteBishop) {
            gamePanel.setPromote('b');
            promoteQueen.setState(false);
            promoteRook.setState(false);
            promoteBishop.setState(true);
            promoteKnight.setState(false);
        } else if (evt.target == promoteKnight) {
            gamePanel.setPromote('n');
            promoteQueen.setState(false);
            promoteRook.setState(false);
            promoteBishop.setState(false);
            promoteKnight.setState(true);
        } else {
            return false;
        }
        return true;
    }
}
