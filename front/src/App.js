import React, { useContext } from "react";
import { ListContext } from "./contexts/ListContext";
import TodoPage from "./Pages/TodoPage";
import { Form } from "./components/FormListas";

export const HOST_API = "http://localhost:8080/api";

const App = () => {
  const todoListas = useContext(ListContext);
  return (
    <div>
      <Form/>
      {todoListas.map((lista) => {
        return <TodoPage key={lista.id} lista={lista} />;
      })}
    </div>
  );
};

export default App;
