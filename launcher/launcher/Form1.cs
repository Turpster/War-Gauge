﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace launcher
{
    public partial class winLauncher : Form
    {
        private Launcher launcher { get; }

        public TextBox TxtPassword
        {
            get
            {
                return this.txtPassword;
            }
        }
        public TextBox TxtUsername
        {
            get
            {
                return this.txtUsername;
            }
        }

        public winLauncher()
        {
            this.launcher = new Launcher(this);
            InitializeComponent();
            this.webUpdates.Refresh();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void btnPlay_Click(object sender, EventArgs e)
        {
            launcher.launch();
        }

        private void txtPassword_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyData == Keys.Return)
            {
                launcher.launch();
            }
        }
    }

    public class Launcher
    {
        private winLauncher winLauncher;

        public Launcher(winLauncher winlauncher)
        {
            this.winLauncher = winlauncher;
        }

        public void launch()
        {
            if (winLauncher.TxtUsername.TextLength != 0)
            {
                if (winLauncher.TxtPassword.TextLength != 0)
                {
                    if (validate())
                    {
                        System.Diagnostics.Process game = new System.Diagnostics.Process();
                        System.Diagnostics.ProcessStartInfo gameStartInfo = new System.Diagnostics.ProcessStartInfo();
                        gameStartInfo.WindowStyle = System.Diagnostics.ProcessWindowStyle.Hidden;
                        gameStartInfo.FileName = System.IO.Path.GetDirectoryName(Application.ExecutablePath) + "\\game\\game.jar";
                        gameStartInfo.Arguments = "-username " + winLauncher.TxtUsername.Text + " -password " + winLauncher.TxtPassword.Text;
                        game.StartInfo = gameStartInfo;
                        game.Start();

                        Application.Exit();
                    }
                    else
                    {
                        MessageBox.Show("Either your username, password or both was or were incorrect", "Incorrect Credentials");
                    }
                }
                else
                {
                    winLauncher.TxtPassword.Focus();
                }
            }
            else
            {
                winLauncher.TxtUsername.Focus();
            }
        }

        public bool validate()
        {
            /*
             * TODO
             * WHEN DATABASE IS MADE, CONFIGURE VALIDATION
             */

            if (winLauncher.TxtPassword.Text.Equals("debug"))
            {
                return false;
            }

            return true;
        }
    }
}
