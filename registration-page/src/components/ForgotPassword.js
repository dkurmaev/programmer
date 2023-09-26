import React, { useState } from "react";
import { Button, TextField, Typography, Paper, Avatar } from "@mui/material";
import { makeStyles } from "@mui/styles";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";

const useStyles = makeStyles((theme) => ({
  container: {
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    padding: theme.spacing(4),
  },
  paper: {
    marginTop: theme.spacing(1),
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    padding: theme.spacing(2),
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.primary.main,
  },
  form: {
    width: "100%",
    marginTop: theme.spacing(1),
  },
  button: {
    marginTop: theme.spacing(2),
  },
}));

function ForgotPassword() {
    const classes = useStyles();
    const [email, setEmail] = useState("");
  
    const handleResetPassword = () => {
      console.log("Requesting password reset for:", email);
    };
  
    const handleChange = (e) => {
      setEmail(e.target.value);
    };
  
    return (
      <div className={classes.container}>
        <Avatar className={classes.avatar}>
          <LockOutlinedIcon />
        </Avatar>
        <Typography variant="h4">Password Reset</Typography>
        <Paper elevation={3} className={classes.paper}>
          <Typography>
            Enter your email address to reset your password.
          </Typography>
          <form className={classes.form}>
            <TextField
              variant="outlined"
              margin="normal"
              required
              fullWidth
              label="Email"
              name="email"
              value={email}
              onChange={handleChange}
            />
            <Button
              className={classes.button}
              variant="contained"
              color="primary"
              onClick={handleResetPassword}
            >
              Reset Password
            </Button>
          </form>
        </Paper>
      </div>
    );
  }
export default ForgotPassword;
