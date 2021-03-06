﻿namespace launcher
{
    partial class winLauncher
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(winLauncher));
            this.txtUsername = new System.Windows.Forms.TextBox();
            this.txtPassword = new System.Windows.Forms.TextBox();
            this.lblUsername = new System.Windows.Forms.Label();
            this.lblPassword = new System.Windows.Forms.Label();
            this.btnPlay = new System.Windows.Forms.Button();
            this.webUpdates = new System.Windows.Forms.WebBrowser();
            this.picGameNameImage = new System.Windows.Forms.PictureBox();
            ((System.ComponentModel.ISupportInitialize)(this.picGameNameImage)).BeginInit();
            this.SuspendLayout();
            // 
            // txtUsername
            // 
            this.txtUsername.Location = new System.Drawing.Point(485, 464);
            this.txtUsername.Name = "txtUsername";
            this.txtUsername.Size = new System.Drawing.Size(145, 20);
            this.txtUsername.TabIndex = 0;
            // 
            // txtPassword
            // 
            this.txtPassword.Location = new System.Drawing.Point(485, 490);
            this.txtPassword.Name = "txtPassword";
            this.txtPassword.PasswordChar = '*';
            this.txtPassword.Size = new System.Drawing.Size(145, 20);
            this.txtPassword.TabIndex = 1;
            this.txtPassword.KeyDown += new System.Windows.Forms.KeyEventHandler(this.txtPassword_KeyDown);
            // 
            // lblUsername
            // 
            this.lblUsername.AutoSize = true;
            this.lblUsername.BackColor = System.Drawing.Color.Transparent;
            this.lblUsername.ForeColor = System.Drawing.Color.White;
            this.lblUsername.Location = new System.Drawing.Point(424, 467);
            this.lblUsername.Name = "lblUsername";
            this.lblUsername.Size = new System.Drawing.Size(55, 13);
            this.lblUsername.TabIndex = 2;
            this.lblUsername.Text = "Username";
            this.lblUsername.Click += new System.EventHandler(this.label1_Click);
            // 
            // lblPassword
            // 
            this.lblPassword.AutoSize = true;
            this.lblPassword.BackColor = System.Drawing.Color.Transparent;
            this.lblPassword.ForeColor = System.Drawing.Color.White;
            this.lblPassword.Location = new System.Drawing.Point(426, 493);
            this.lblPassword.Name = "lblPassword";
            this.lblPassword.Size = new System.Drawing.Size(53, 13);
            this.lblPassword.TabIndex = 3;
            this.lblPassword.Text = "Password";
            this.lblPassword.Click += new System.EventHandler(this.label2_Click);
            // 
            // btnPlay
            // 
            this.btnPlay.BackColor = System.Drawing.Color.Transparent;
            this.btnPlay.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.btnPlay.Font = new System.Drawing.Font("Alegreya Sans SC", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnPlay.Location = new System.Drawing.Point(636, 464);
            this.btnPlay.Name = "btnPlay";
            this.btnPlay.Size = new System.Drawing.Size(130, 46);
            this.btnPlay.TabIndex = 4;
            this.btnPlay.Text = "play";
            this.btnPlay.UseVisualStyleBackColor = false;
            this.btnPlay.Click += new System.EventHandler(this.btnPlay_Click);
            // 
            // webUpdates
            // 
            this.webUpdates.Location = new System.Drawing.Point(0, -1);
            this.webUpdates.MinimumSize = new System.Drawing.Size(20, 20);
            this.webUpdates.Name = "webUpdates";
            this.webUpdates.Size = new System.Drawing.Size(778, 459);
            this.webUpdates.TabIndex = 5;
            this.webUpdates.Url = new System.Uri("http://turpster.github.io/War-Gauge/", System.UriKind.Absolute);
            // 
            // picGameNameImage
            // 
            this.picGameNameImage.BackColor = System.Drawing.Color.Transparent;
            this.picGameNameImage.Cursor = System.Windows.Forms.Cursors.Default;
            this.picGameNameImage.ImageLocation = "C:\\Users\\dicky\\OneDrive\\Onedrive Documents\\GitHub\\Multiplayer-Game-Java-Testing\\u" +
    "k\\co\\Turpster\\launcher\\bin\\Debug\\assets\\Title-launcher.png";
            this.picGameNameImage.Location = new System.Drawing.Point(12, 467);
            this.picGameNameImage.Name = "picGameNameImage";
            this.picGameNameImage.Size = new System.Drawing.Size(293, 50);
            this.picGameNameImage.TabIndex = 6;
            this.picGameNameImage.TabStop = false;
            // 
            // winLauncher
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.ClientSize = new System.Drawing.Size(778, 522);
            this.Controls.Add(this.picGameNameImage);
            this.Controls.Add(this.webUpdates);
            this.Controls.Add(this.btnPlay);
            this.Controls.Add(this.lblPassword);
            this.Controls.Add(this.lblUsername);
            this.Controls.Add(this.txtPassword);
            this.Controls.Add(this.txtUsername);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "winLauncher";
            this.Text = "War Gauge";
            ((System.ComponentModel.ISupportInitialize)(this.picGameNameImage)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txtUsername;
        private System.Windows.Forms.TextBox txtPassword;
        private System.Windows.Forms.Label lblUsername;
        private System.Windows.Forms.Label lblPassword;
        private System.Windows.Forms.Button btnPlay;
        private System.Windows.Forms.WebBrowser webUpdates;
        private System.Windows.Forms.PictureBox picGameNameImage;
    }
}

