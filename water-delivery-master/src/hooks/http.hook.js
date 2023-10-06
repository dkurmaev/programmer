import React from "react"

export const useHttp = () => {
  const [isLoading, setLoading] = React.useState(false)
  const [error, setError] = React.useState(null)
  const [responseStatus, setResponseStatus] = React.useState(null)

  const request = React.useCallback(async (url, method = 'GET', body = null, headers = {}, params={}) => {
    setLoading(true)
    try {
      if (body) {
        body = JSON.stringify(body)
        headers['Content-Type'] = 'application/json'
      }

      const response = await fetch(url, {method, body, headers})
      const data = await response.json()
      setResponseStatus(response.status)

      if (!response.ok) {
        let errorMessage = data.message
        if (data.errors) {
          errorMessage = data.errors[0].msg
        }
        throw new Error(errorMessage || 'Что-то не так...')
      }
      setLoading(false)
      return data
    } catch (error) {
      setLoading(false)
      setError(error.message)
      throw error
    }
  }, [])

  const clearError = React.useCallback(() => setError(null), [])

  return {
    isLoading,
    request,
    error,
    clearError,
    responseStatus
  }
}