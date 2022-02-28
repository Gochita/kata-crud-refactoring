import React from "react";

const Listilla = () => {
  // const { state: { todo } } = useContext(props.store);
  // const currentList = todo.list;
  return (
    <div>
      <div>Crea nuevas listas</div>
      <input
        type="text"
        name="name"
        placeholder="¿Que mas quieres hacer?"
        className="me-3"
      ></input>
     
      <button className="btn btn-success" >Agregar Lista</button>

      
    </div>
  );
};

export default Listilla;
