import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
import { TodoContextProvider } from "./contexts/todoContext";
import { ListContextProvider } from "./contexts/ListContext";

ReactDOM.render(
  <ListContextProvider>
    <TodoContextProvider>
        <App />   
    </TodoContextProvider>
  </ListContextProvider>,

  document.getElementById("root")
);
