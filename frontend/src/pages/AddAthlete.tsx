import { useRef } from 'react'
import { ToastContainer, toast } from "react-toastify";

function AddAthlete() {

    const inputRefAthleteName = useRef<HTMLInputElement>(null);
    const inputRefAthleteCountry = useRef<HTMLInputElement>(null);
    const inputRefAthleteAge = useRef<HTMLInputElement>(null);

    function addAthlete () {
    
        if (inputRefAthleteName.current === null || inputRefAthleteCountry.current === null || inputRefAthleteAge.current === null) {
         console.log("Mingi REF jäi HTMLi lisamata.")
         return ;
       }
    
        fetch("http://localhost:8080/athletes", {
          method: "POST",
          headers: {
            "Content-Type": "Application/JSON",
          },
          body: JSON.stringify({
            "name": inputRefAthleteName.current.value,
            "country": inputRefAthleteCountry.current.value,
            "age": inputRefAthleteAge.current.value,
          })
        })
          .then((respose) => respose.json())
          .then(json => {
            if (json.timestamp && json.status && json.error) {
            toast.error(json.error);
            } else {
            toast.success("Edukalt lisatud")
            }
        });
      };

  return (
    <div>

    <label style={{ marginRight: '10px' }}>Athlete name:</label>
    <input type="text" ref={inputRefAthleteName} style={{ marginLeft: '5px' }} /> <br />
    <label style={{ marginRight: '10px' }}>Athlete country:</label>
    <input type="text" ref={inputRefAthleteCountry} style={{ marginLeft: '5px' }} /> <br />
    <label style={{ marginRight: '10px' }}>Athlete age:</label>
    <input type="text" ref={inputRefAthleteAge} style={{ marginLeft: '5px' }} /> <br />
    <button onClick={addAthlete}>Add athlete</button> <br /> <br />

    <ToastContainer 
        position="bottom-right"
        autoClose={4000}
        theme="dark"/>
    </div>
  )
}

export default AddAthlete