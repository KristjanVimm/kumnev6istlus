import { useEffect, useState } from "react";
import { Athlete } from "../models/Athlete";


function HomePage() {

    const [athletes, setAthletes] = useState<Athlete[]>([]);
    const [totalAthletes, setTotalAthletes] = useState<number>();
    const [pages, setPages] = useState<number[]>([]);
    const [activePage, setActivePage] = useState(1);
    const size = 3;

    // useEffect(() => {
    //     fetch("http://localhost:8080/athletes")
    //     .then(res => res.json())
    //     .then(json => setAthletes(json));
    // }, []);

    useEffect(() => {
        fetch(`http://localhost:8080/public-athletes?size=${size}&page=${activePage-1}`)
        .then(res => res.json())
        .then(json => {
            setAthletes(json.content);
            setTotalAthletes(json.totalElements);
            const pagesArray = [];
            for (let page = 1; page <= json.totalPages; page++) {
                pagesArray.push(page);
            }
            setPages(pagesArray);
        });
    }, [activePage]);

    const getAthleteScore = (athlete: Athlete) => {
        fetch(`http://localhost:8080/athlete-score?athleteId=${athlete.athleteId}`, {
        method: "GET",
        headers: {
            "Content-Type": "Application/JSON",
        },
        })
        .then((response) => response.json())
        .then((response) => alert("score for " + athlete.name + " is: " + response))
    }

    function changePage(newPage: number) {
      setActivePage(newPage);
    }

    return (
        <div className='home-page-div'>
            <div>
                Number of athletes: {totalAthletes}
            </div>
            <div>
                {athletes.map(athlete => 
                <div key={athlete.athleteId}>
                    <span onClick={() => getAthleteScore(athlete)}>
                        {athlete.name}
                    </span>
                </div>
                )}
            </div>
            <br></br>
            {pages.map(page => 
                <button onClick={() => changePage(page)} key={page}>{page}</button>
            )}
        </div>
    )
}

export default HomePage