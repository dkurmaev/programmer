import React from 'react'
import styles from "../../styles/Footer.module.css"
import {Link} from "react-router-dom";
import {ROUTES} from "../../utils/routes";
import LOGO from "../../images/logo.svg";

const Footer = () => {
    return (
        <section className={styles.footer}>
            <div className={styles.logo}>
                <Link to={ROUTES.HOME}>
                    <img src={LOGO} alt="Space Burger"/>
                </Link>
            </div>
            <div className={styles.rights}>
                © 2023 Danil Kurmayev.{""}
                {/* eslint-disable-next-line jsx-a11y/anchor-is-valid */}
                <a
                    href="#"
                    target={"_blank"}
                    rel={"no referrer"}
                >
                    All rights reserved
                </a>
            </div>
            <div className={styles.socials}>
                <a  href="#"
                    target={"_blank"}
                    rel={"no referrer"}
                >
                    <svg className="icon">
                        <use xlinkHref={`${process.env.PUBLIC_URL}/sprite.svg#instagram`}/>
                    </svg>
                </a>
                <a  href="#"
                    target={"_blank"}
                    rel={"no referrer"}
                >
                    <svg className="icon">
                        <use xlinkHref={`${process.env.PUBLIC_URL}/sprite.svg#facebook`}/>
                    </svg>
                </a>
                <a  href="#"
                    target={"_blank"}
                    rel={"no referrer"}
                >
                    <svg className="icon">
                        <use xlinkHref={`${process.env.PUBLIC_URL}/sprite.svg#youtube`}/>
                    </svg>
                </a>
            </div>
        </section>
    )
}
export default Footer
