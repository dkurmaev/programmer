import React, { useState, useEffect } from 'react'
import { FaAngleDoubleRight } from 'react-icons/fa'
// ATTENTION!!!!!!!!!!
// I SWITCHED TO PERMANENT DOMAIN
// https://react-icons.github.io/react-icons/      npm install react-icons --save
const url = 'https://course-api.com/react-tabs-project'
// Эта константа содержит URL-адрес, с которого загружаются данные о рабочих местах.
function App() {
  const [loading, setLoading] = useState(true)
  const [jobs, setJobs] = useState([])
  const [value, setValue] = useState(0)
// В компоненте App используются хуки useState для создания состояний:
// loading - для отображения индикатора загрузки,
// jobs - для хранения данных о рабочих местах,
// value - для отслеживания выбранного рабочего места.
  const fetchJobs = async () => {
    const reponse = await fetch(url)
    const newJobs = await reponse.json()
    // В этой строке выполняется асинхронный запрос (используя ключевое слово await)
    // к указанному URL-адресу (url). Функция fetch возвращает объект Response,
    // представляющий ответ на запрос.
    setJobs(newJobs)
    setLoading(false)
    // После того как данные успешно загружены и установлены в состояние jobs,
    // эта строка устанавливает состояние loading в false.
    // Это означает, что данные были загружены, и теперь компонент может отобразить
    // содержимое на экране, заменяя сообщение о загрузке.
  }
  
    // newJobs содержит полученные данные о рабочих местах в виде JavaScript объекта.
    // В этой строке используется функция setJobs (которую предоставляет useState хук)
    // для обновления состояния jobs новыми данными. После выполнения этой строки,
    // состояние jobs будет содержать полученные данные.
  useEffect(() => {
    fetchJobs()
  }, [])
  // Этот хук вызывает функцию fetchJobs при монтировании компонента
  // ([] - это массив зависимостей, который пуст,
  // поэтому эффект будет выполняться только один раз после монтирования).
  if (loading) {
    return (
      <section className="section loading">
        <h1>Loading...</h1>
      </section>
    )
  }//Если данные еще загружаются, отображается сообщение о загрузке.


  const { company, dates, duties, title } = jobs[value]
  // Эта строка извлекает данные о выбранном рабочем месте из массива jobs.
  return (
    <section className="section">
      <div className="title">
        <h2>experience</h2>
        <div className="underline"></div>
      </div>
      <div className="jobs-center">
        {/* btn container */}
        <div className="btn-container">
          {jobs.map((item, index) => {
            // Это выражение использует метод map(),
            // чтобы пройти по каждому элементу массива jobs. map() создает новый массив
            // из результатов вызова предоставленной функции для каждого элемента в массиве jobs.
            return (
              <button
                key={item.id}
                // Здесь создается кнопка для каждой компании. Обратите внимание на следующие атрибуты:
                //key={item.id}: Атрибут key используется React для уникальной идентификации каждого
                // элемента списка. В данном случае, item.id используется в качестве ключа.
                onClick={() => setValue(index)}
                //Когда кнопка нажимается, вызывается функция, которая устанавливает значение index
                // в качестве нового значения состояния value. Таким образом,
                // при нажатии на кнопку, выбирается соответствующая компания из списка рабочих мест.
                className={`job-btn ${index === value && 'active-btn'}`}>
                  {/*Это выражение динамически определяет классы для кнопки.
                   Если index равен текущему значению состояния value,
                    кнопке добавляется класс active-btn, который,  изменяет стиль кнопки,
                     чтобы пользователь мог видеть, какая компания выбрана. */}
                {item.company}
                {/* Текст, отображаемый на кнопке,
                 извлекается из свойства company объекта item в массиве jobs. */}
              </button>
            )
          })}
        </div>
        {/* job info */}
        <article className="job-info">
          <h3>{title}</h3>
          <h4>{company}</h4>
          <p className="job-date">{dates}</p>
          {duties.map((duty, index) => {
            // Этот фрагмент кода отображает список обязанностей  внутри выбранной компании.
            // duties - это массив обязанностей, который также извлекается из данных о выбранной компании.
            // map() используется для прохода по каждому  массиву и  отображения значения каждого элемента в duty.
            return (
              <div key={index} className="job-desc">
                {/*Этот элемент <div> содержит каждую обязанность и имеет класс job-desc. */}
                <FaAngleDoubleRight className="job-icon"></FaAngleDoubleRight>
                <p>{duty}</p>
              </div>
            )
          })}
        </article>
      </div>
      <button type="button" className="btn">
        <a href={url} target="_blank" >
          more info
        </a>
      </button>
    </section>
  )
}

export default App
