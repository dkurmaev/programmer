import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import LoginForm from "./components/Login";
import RegisterForm from "./components/Register";
import ForgotPasswordForm from "./components/ForgotPassword";



function App() {
  return (
    <Router>
      <Routes>
  <Route path="/register" element={<RegisterForm />} />
  <Route path="/login" element={<LoginForm />} />
  <Route path="/forgot-password" element={<ForgotPasswordForm />} />
</Routes>
    </Router>
  );
}

export default App;
