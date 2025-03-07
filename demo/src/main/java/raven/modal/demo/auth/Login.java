package raven.modal.demo.auth;

import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.swing.MigLayout;
import raven.modal.demo.system.Form;
import raven.modal.demo.system.FormManager;
import raven.modal.demo.utils.AuthClient;
import raven.modal.demo.utils.AuthToken;

import javax.swing.*;

public class Login extends Form {
    @Override
    protected void init() {
        this.setLayout(new MigLayout("fill,insets 20", "[center]", "[center]"));
        this.txtUsername = new JTextField();
        this.txtPassword = new JPasswordField();
        this.cmdLogin = new JButton("Login");
        JPanel panel = new JPanel(new MigLayout("wrap,fillx,insets 35 45 35 45", "fill,250:280"));
        panel.putClientProperty(FlatClientProperties.STYLE, "" +
                "arc:20;" +
                "[light]background:shade($Panel.background,5%);" +
                "[dark]background:tint($Panel.background,5%);");

        this.txtPassword.putClientProperty(FlatClientProperties.STYLE, "" +
                "showRevealButton:true");
        cmdLogin.putClientProperty(FlatClientProperties.STYLE, "" +
                "[light]background:shade($Panel.background,10%);" +
                "[dark]background:tint($Panel.background,10%);" +
                "borderWidth:0;" +
                "focusWidth:0;" +
                "innerFocusWidth:0");

        this.txtUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "username");
        this.txtPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "password");

        JLabel lbTitle = new JLabel("DoorDev Sistemas!");
        JLabel description = new JLabel("Acesse o sistema com login e senha");
        lbTitle.putClientProperty(FlatClientProperties.STYLE, "" + "font:bold +10");
        description.putClientProperty(FlatClientProperties.STYLE, "" + "foreground:$Label.disabledForeground;");
        panel.add(lbTitle);
        panel.add(description);
        panel.add(new JLabel("Username"), "gapy 8");
        panel.add(this.txtUsername);
        panel.add(new JLabel("Password"), "gapy 8");
        panel.add(this.txtPassword);
        panel.add(this.cmdLogin, "gapy 10");
        add(panel);

        this.cmdLogin.addActionListener((e) -> {
            FormManager.login();
//            AuthToken.clear();
//            AuthClient authClient = new AuthClient();
//            String tokenJWT = authClient.obterTokenJWT(this.txtUsername.getText().trim(), this.txtPassword.getText());
//
//            if (tokenJWT != null) {
//                AuthToken.setToken(tokenJWT);
//                FormManager.login();
//            } else {
//                JOptionPane.showMessageDialog(this, "Falha no login!!");
//            }
        });
    }

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton cmdLogin;
}
