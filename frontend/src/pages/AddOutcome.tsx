import { useRef } from 'react'
import { ToastContainer, toast } from "react-toastify";

function AddOutcome() {

    const athleteIdRef = useRef<HTMLInputElement>(null);
    const eventIdRef = useRef<HTMLInputElement>(null);
    const outcomeRef = useRef<HTMLInputElement>(null);

    function addOutcome () {

        if (athleteIdRef.current === null || eventIdRef.current === null || outcomeRef.current === null) {
          console.log("Mingi REF jäi HTMLi lisamata.")
          return ;
        }
    
        fetch("http://localhost:8080/add-outcome", {
          method: "POST",
          headers: {
            "Content-Type": "Application/JSON",
          },
          body: JSON.stringify({
            "athleteId": athleteIdRef.current.value,
            "eventId": eventIdRef.current.value,
            "outcome": outcomeRef.current.value,
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
        <label style={{ marginRight: '10px' }}>Athlete id:</label>
        <input type="text" ref={athleteIdRef} style={{ marginLeft: '5px' }} /> <br />
        <label style={{ marginRight: '10px' }}>Event id:</label>
        <input type="text" ref={eventIdRef} style={{ marginLeft: '5px' }} /> <br />
        <label style={{ marginRight: '10px' }}>Outcome:</label>
        <input type="text" ref={outcomeRef} style={{ marginLeft: '5px' }} /> <br />
        <button onClick={addOutcome}>Submit</button>
        <ToastContainer 
        position="bottom-right"
        autoClose={4000}
        theme="dark"/>
      </div>
  )
}

export default AddOutcome